package ATU_Program;

import org.apache.poi.ss.util.CellRangeAddress;

public class Output {
	public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        HSSFSheet sheet = workbook.createSheet("sheet");

        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell_00 = row0.createCell(0);
        cell_00.setCellStyle(style);
        cell_00.setCellValue("����");
        HSSFCell cell_01 = row0.createCell(1);
        cell_01.setCellStyle(style);
        cell_01.setCellValue("���");

        HSSFRow row1 = sheet.createRow(1);
        HSSFCell cell_10 = row1.createCell(0);
        cell_10.setCellStyle(style);
        cell_10.setCellValue("20180412");
        HSSFCell cell_11 = row1.createCell(1);
        cell_11.setCellStyle(style);
        cell_11.setCellValue("����");

        HSSFRow row2 = sheet.createRow(2);
        HSSFCell cell_21 = row2.createCell(1);
        cell_21.setCellStyle(style);
        cell_21.setCellValue("����");

        // �ϲ�����ռ����(4���������ֱ�Ϊ��ʼ�У������У���ʼ�У�������)
        // �к��ж��Ǵ�0��ʼ����������ʼ��������ϲ�
        // �����Ǻϲ�excel�����ڵ�����Ϊһ��
        CellRangeAddress region = new CellRangeAddress(1, 2, 0, 0);
        sheet.addMergedRegion(region);

        File file = new File("E:\\demo.xls");
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        fout.close();
    }
}
