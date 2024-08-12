/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.controller;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.bson.Document;

/**
 *
 * @author Joffre
 */
public class PrintoutFlightController {
       public void createPdf(String filePath, List<Document> flights) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = null;

        try {
            contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 750);

            contentStream.showText("Vuelos Registrados");
            contentStream.newLine();
            contentStream.newLine();

            int lineHeight = 14;
            int maxLinesPerPage = 30;
            int lineCount = 0;

            for (Document flight : flights) {
                if (lineCount >= maxLinesPerPage) {
                    contentStream.endText();
                    contentStream.close();

                    page = new PDPage();
                    document.addPage(page);

                    contentStream = new PDPageContentStream(document, page);
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contentStream.setLeading(14.5f);
                    contentStream.newLineAtOffset(25, 750);

                    lineCount = 0;
                }

                contentStream.showText("Número de Vuelo: " + flight.getString("flightID"));
                contentStream.newLine();
                contentStream.showText("Aerolínea: " + flight.getString("airline"));
                contentStream.newLine();
                contentStream.showText("Origen: " + flight.getString("origin"));
                contentStream.newLine();
                contentStream.showText("Destino: " + flight.getString("destination"));
                contentStream.newLine();
                contentStream.showText("Fecha de Salida: " + flight.getDate("departureDate"));
                contentStream.newLine();
                contentStream.showText("Fecha de Llegada: " + flight.getDate("arrivalDate"));
                contentStream.newLine();
                contentStream.newLine();

                lineCount += 6;
            }

            contentStream.endText();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (contentStream != null) {
                    contentStream.close();
                }
                document.save(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
