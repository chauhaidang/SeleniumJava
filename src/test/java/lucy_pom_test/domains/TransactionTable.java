package lucy_pom_test.domains;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionTable extends Page {

    private WebElement table;
    private WebElement tableHeader;
    private WebElement tableBody;
    private List<WebElement> rows_table;

    public TransactionTable() {
        table = driver.findElement(By.cssSelector(OR.getProperty("CustomerDetail.Transactions.tableTransactions.css")));
    }

    public WebElement getTableHeader() {
        return table.findElement(By.cssSelector("thead"));
    }

    private WebElement getTableBody() {
        return table.findElement(By.cssSelector("tbody"));
    }

    public List<WebElement> getTableRows() {
        return getTableBody().findElements(By.tagName("tr"));
    }

    public Object[][] buildTable() {
        tableHeader = getTableHeader();
        tableBody = getTableBody();
        rows_table = getTableRows();

        int rows_count = rows_table.size();
        int cols_count = rows_table.get(0).findElements(By.tagName("td")).size();
        Object[][] object = new Object[rows_count][cols_count];

        for (int row = 0; row < rows_count; row++) {
            List<WebElement> cols_table = rows_table.get(row).findElements(By.tagName("td"));
            for (int col = 0; col < cols_count; col++) {
                String cellText = cols_table.get(col).getText();
                System.out.println("Value of row " + (row + 1) + " and column " + (col + 1) + " is " + cellText);
                object[row][col] = cellText;
            }
        }
        return object;
    }
}
