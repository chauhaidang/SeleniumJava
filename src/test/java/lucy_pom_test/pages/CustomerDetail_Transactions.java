package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import lucy_pom_test.domains.TransactionTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerDetail_Transactions extends Page {

    private TransactionTable transactionTable = new TransactionTable();

    public String getTransactionTableHeader(){
        return transactionTable.getTableHeader().getText();
    }

    public Object[][] getTransactionTable(){
        return transactionTable.buildTable();
    }

    public String getDateTime(int rowNumber){
        return getTransactionTable()[rowNumber][0].toString();
    }

    public String getFirstDateTime(){
        return getDateTime(0);
    }

    public String getLastDatetime(){
        return getDateTime(transactionTable.getTableRows().size() - 1);
    }

    public String getAmount(int rowNumber){
        Object[][] table = getTransactionTable();
        return table[rowNumber][1].toString();
    }

    public String getFirstAmount(){
        return getAmount(0);
    }

    public String getLastAmount(){
        return getAmount(transactionTable.getTableRows().size() - 1);
    }

    public String getTransactionType(int rowNumber){
        return getTransactionTable()[rowNumber][2].toString();
    }

    public String getFirstTransactionType(){
        return getTransactionType(0);
    }

    public String getLastTransactionType(){
        return getTransactionType(transactionTable.getTableRows().size() - 1);
    }

    public void clickBack(){
        click("CustomerDetail.Transactions.btnBack.css");
    }
}
