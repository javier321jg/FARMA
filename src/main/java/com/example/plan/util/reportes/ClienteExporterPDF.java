
package com.example.plan.util.reportes;

import com.example.plan.entity.Cliente;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javier_gr
 */
public class ClienteExporterPDF {
    
    private List<Cliente> listaClientes;

    public ClienteExporterPDF(List<Cliente> listaClientes) {
        super();
        this.listaClientes = listaClientes;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(6);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombres", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Apellidos", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Telefono", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Dni", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Correo", fuente));
        tabla.addCell(celda);
        
        celda.setPhrase(new Phrase("Estado", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Cliente cliente : listaClientes) {
            tabla.addCell(String.valueOf(cliente.getId()));
            tabla.addCell(cliente.getNombres());
            tabla.addCell(cliente.getApellidos());
            tabla.addCell(String.valueOf(cliente.getTelefono()));
            tabla.addCell(String.valueOf(cliente.getDni()));
            tabla.addCell(cliente.getCorreo());
            tabla.addCell(Boolean.toString(cliente.isEstado()));
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de clientes", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        Image image = null;
        image = Image.getInstance("C:\\Users\\javier_gr\\Pictures\\Nueva carpeta\\1111.png");
        image.scaleAbsolute(70, 70);
        image.setAbsolutePosition(510, 760); 
        documento.add(image);
        documento.add(titulo);
        documento.add(Chunk.NEWLINE);

        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{1f, 2.3f, 2.3f, 6f, 2.9f, 3.9f, 3.8f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}


