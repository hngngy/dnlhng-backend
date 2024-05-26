package dnlhng.webtech.dnlhng.web.api;

public class Nachricht {
    private String benutzername;
    private String text;
    private String zeitstempel; // Dies wird verwendet, um den Zeitpunkt der Nachricht zu speichern

    public Nachricht(String benutzername, String text) {
        this.benutzername = benutzername;
        this.text = text;
        this.zeitstempel = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new java.util.Date());
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(String zeitstempel) {
        this.zeitstempel = zeitstempel;
    }
}