package hu.sigmalimited.sigmawebshop.domain.data.user;

public enum UserRole {
    ADMIN,
    SUPPORT,
    CUSTOMER;

    @Override
    public String toString(){
        return String.format("ROLE_%s",super.toString());
    }
}