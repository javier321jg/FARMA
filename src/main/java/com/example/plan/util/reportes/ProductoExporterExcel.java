package com.example.plan.util.reportes;

import com.example.plan.entity.Cliente;
import com.example.plan.entity.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ProductoExporterExcel {

    private XSSFWorkbook producto;
    private XSSFSheet hoja;

    private List<Producto> listaProductos;

    public ProductoExporterExcel(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        producto = new XSSFWorkbook();
        hoja = producto.createSheet("Productos");
    }

    

    private void escribirCabeceraDeTabla() {
        Row fila = hoja.createRow(0);

        CellStyle estilo = producto.createCellStyle();
        XSSFFont fuente = producto.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Nombre");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Precio");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Laboratorio");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Presentacion");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("stock");
        celda.setCellStyle(estilo);
    }

    private void escribirDatosDeLaTabla() {
        int nueroFilas = 1;

        CellStyle estilo = producto.createCellStyle();
        XSSFFont fuente = producto.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Producto pro : listaProductos) {
            Row fila = hoja.createRow(nueroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(pro.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(pro.getNombre());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(pro.getPrecio());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(pro.getLaboratorio().getNombre());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(pro.getPresentacion().getDescripcion());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(pro.getStock());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        escribirCabeceraDeTabla();
        escribirDatosDeLaTabla();

        ServletOutputStream outPutStream = response.getOutputStream();
        producto.write(outPutStream);

        producto.close();
        outPutStream.close();
    }
}
