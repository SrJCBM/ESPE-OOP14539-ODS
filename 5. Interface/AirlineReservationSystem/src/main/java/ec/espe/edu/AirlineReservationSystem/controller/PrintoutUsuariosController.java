package ec.espe.edu.AirlineReservationSystem.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.bson.Document;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */

public class PrintoutUsuariosController {

    public void createPdf(String filePath, List<Document> users) {
        PDDocument document = new PDDocument();

        try {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 750);

            contentStream.showText("Usuarios Registrados");
            contentStream.newLine();
            contentStream.newLine();

            int lineHeight = 14;
            int maxLinesPerPage = 30;
            int lineCount = 0;

            for (Document user : users) {
                if (lineCount + 9 >= maxLinesPerPage) {  // +9 para incluir líneas de usuario y una línea en blanco
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

                String userLine = formatUserLine(user);
                String[] userLines = userLine.split("\n");

                for (String line : userLines) {
                    contentStream.showText(line);
                    contentStream.newLine();
                    lineCount++;
                }

                contentStream.newLine();  // Añadir una línea en blanco entre usuarios
                lineCount++;
            }

            contentStream.endText();
            contentStream.close();

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

    private String formatUserLine(Document user) {
        return String.format("ID: %s\nNombre: %s\nEmail: %s\nCelular: %s\nCiudad: %s\nProvincia: %s\nCódigo Postal: %s\nFecha de Nacimiento: %s\nGénero: %s",
            user.getString("id"),
            user.getString("name"),
            user.getString("email"),
            user.getString("phoneNumber"),
            user.getString("city"),
            user.getString("state"),
            user.getString("postalCode"),
            user.get("dateOfBirth").toString(),
            user.getString("gender"));
    }
}