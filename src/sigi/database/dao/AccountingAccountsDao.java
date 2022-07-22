package sigi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import sigi.database.dto.AccountingAccountsDto;
import sigi.database.lib.IDataSource;

public class AccountingAccountsDao {
    private IDataSource dataSource = null;

    public AccountingAccountsDao(IDataSource ds){
        this.dataSource = ds;
    }

    public void setDataSource(IDataSource ds){
        this.dataSource = ds;
    }

    public ArrayList<AccountingAccountsDto>getListAccountingA(){
        ArrayList<AccountingAccountsDto> accounting = new ArrayList<AccountingAccountsDto>();
        
        try{
                String sql = "Select TOP 20  Name, Description, Status, AccountType from AccountingAccounts where  AccountType = '2' ORDER BY Id DESC";

                PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);

                ResultSet rs = this.dataSource.execute(ps);

                while(rs.next()){
                         AccountingAccountsDto accountings = new AccountingAccountsDto();
                        accountings.setName(rs.getString("Name"));
                        accountings.setDescription(rs.getString("Description"));
                    accountings.setStatus(rs.getInt("Status"));
                accountings.setAccountType(rs.getInt("AccountType"));                  
            accounting.add(accountings);
            
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        return accounting;
    }


public boolean setAccounting(ArrayList<AccountingAccountsDto> myaccounting){
    boolean flag = false;
      try {
        String sql = "Insert into accounting_accounts(name, description, status, account_type_id) VALUES(?, ?, ?, ?)";

        for (AccountingAccountsDto a:myaccounting){
            PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);
            ps.setString(1,a.getName());
            ps.setString(2,a.getDescription());
            ps.setInt(3,a.getStatus());
            ps.setInt(4,a.getAccountType());
            ps.executeUpdate();
        }
        flag = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
      return flag;
}
 
}