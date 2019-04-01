package lk.nsbm.onlinefoodorderingsystem.dto;

public class ContactDetailsDto {
    private int contactId;
    private String name;
    private String email;
    private String subject;
    private String message;

    public ContactDetailsDto() {
    }

    public ContactDetailsDto(int contactId, String name, String email, String subject, String message) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
