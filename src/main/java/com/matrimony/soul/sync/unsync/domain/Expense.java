package com.matrimony.soul.sync.unsync.domain;

public class Expense {
    private int id;
    private String expense_type;
    private double amount;
    private int invoice_id;
    private int organizer_id;

    public Expense(){}

    public Expense(int id, String expense_type, double amount, int invoice_id, int organizer_id) {
        this.id = id;
        this.expense_type = expense_type;
        this.amount = amount;
        this.invoice_id = invoice_id;
        this.organizer_id = organizer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(String expense_type) {
        this.expense_type = expense_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expense_type='" + expense_type + '\'' +
                ", amount=" + amount +
                ", invoice_id=" + invoice_id +
                ", organizer_id=" + organizer_id +
                '}';
    }
}
