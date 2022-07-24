package sigi.services;

import sigi.database.dao.AccountingAccountsDao;
import sigi.database.dto.AccountingAccountsDto;
import sigi.database.lib.DataSourceFactory;
import java.util.ArrayList;


public class AccountingAService {
    private static AccountingAService instance = null;

    private AccountingAccountsDao AccountingA= null;

    ArrayList <AccountingAccountsDto> accounting = new ArrayList<AccountingAccountsDto>();

    private AccountingAService(){}

    public static AccountingAService getInstance(){
        if(!(instance instanceof AccountingAService)){
            instance = new AccountingAService();
        }
        return instance;
    }
         public void execute(){
            this.migrateAccounting();
            this.migrateAccountingA();
         }

         public void migrateAccounting(){
            try{
                  AccountingA = new AccountingAccountsDao(DataSourceFactory.getDataSource("SQLServer"));
                    
                 accounting = AccountingA.getListAccountingA();
                 for(AccountingAccountsDto Adto :accounting){
                    System.out.println(" Name"+Adto.getName()+" Description"+Adto.getDescription()+" Status"+Adto.getStatus()+" AccountType"+Adto.getAccountType());
                 }
            }catch(Exception e){
                e.printStackTrace();
            }
         }

         public void migrateAccountingA(){
            try {
                  AccountingA.setDataSource(DataSourceFactory.getDataSource("MySql"));
                
                  if(AccountingA.setAccounting(this.accounting))
                {
                    System.out.println("Insersion con exito");
                    
                 }else{
                    System.out.println("Error ...");
                 }
            } catch (Exception e) {
        e.printStackTrace();
            }
         }
}
