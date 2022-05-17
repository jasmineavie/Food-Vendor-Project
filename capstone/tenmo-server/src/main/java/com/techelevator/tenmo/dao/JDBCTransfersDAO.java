package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCTransfersDAO implements TransfersDAO {

    private JdbcTemplate jdbcTemplate;
    //To do
    @Override
    public List<Transfers> allTransfers() {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfer WHERE transfer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Transfers> transfers = new ArrayList<>();

        while (results.next()){
            transfers.add(mapRowToTransfers(results));
        }
        return transfers;
    }
//**********************************************************************************************************************
    @Override
    public List<Transfers> transfersByUserId(int userId) {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfer JOIN account ON account.account_id = transfer.account_from WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Transfers> transfers = new ArrayList<>();
        while (results.next()){
            transfers.add(mapRowToTransfers(results));
        }
        return transfers;
    }

    @Override
    public List<Transfers> pendingTransfers(int userId) {

        return null;
    }
//**********************************************************************************************************************

    @Override
    public void createTransfer(Transfers transfers) {
        String sql = "INSERT INTO transfer (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?, ?";
        jdbcTemplate.update(sql, transfers.getTransferId(), transfers.getTransferDescriptionId(), transfers.getTransferStatusId(), transfers.getFromAccount(), transfers.getToAccount(), transfers.getAmount());
    }

    @Override
    public void changeTransfers(Transfers transfers) {
        String sql = "UPDATE transfer SET transfer_status_id = ? WHERE transfer_id = ?";
        jdbcTemplate.update(sql, transfers.getTransferStatusId(), transfers.getTransferId());
    }
    @Override
    public Transfers getTransfersByTransfersId(int transfersId) {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfer";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transfersId);
        Transfers transfers = null;

        if (results.next()){
            transfers = mapRowToTransfers(results);
        }
        return transfers;
    }

    private Transfers mapRowToTransfers(SqlRowSet results){
        int transferId = results.getInt("transfer_id");
        int transferDescriptionId = results.getInt("transfer_type_id");
        int statusId = results.getInt("transfer_status_id");
        int toAccount = results.getInt("account_to");
        int fromAccount = results.getInt("account_from");
        String ammount = results.getString("amount");

        Transfers transfers = new Transfers(transferId, transferDescriptionId, statusId, toAccount, fromAccount, new BigDecimal(ammount));
        return transfers;
    }

}
