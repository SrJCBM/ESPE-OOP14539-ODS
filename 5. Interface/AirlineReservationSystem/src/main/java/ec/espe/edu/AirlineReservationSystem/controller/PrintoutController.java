package ec.espe.edu.AirlineReservationSystem.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class PrintoutController {

    public void createPdf(String filePath, List<Document> tickets) {
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

            contentStream.showText("Tickets Registrados");
            contentStream.newLine();
            contentStream.newLine();

            int lineHeight = 14;
            int maxLinesPerPage = 30;
            int lineCount = 0;

            for (Document ticket : tickets) {
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

                contentStream.showText("Número de Ticket: " + ticket.getInteger("Number of Ticket"));
                contentStream.newLine();
                contentStream.showText("Ticket ID: " + ticket.getInteger("Ticket ID"));
                contentStream.newLine();
                contentStream.showText("Nombre del Cliente: " + ticket.getString("Customer Name"));
                contentStream.newLine();
                contentStream.showText("Flight ID: " + ticket.getInteger("Id Flight"));
                contentStream.newLine();
                contentStream.showText("Ticket Class: " + ticket.getString("Ticket Class"));
                contentStream.newLine();
                contentStream.newLine();

                lineCount += 5;
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
