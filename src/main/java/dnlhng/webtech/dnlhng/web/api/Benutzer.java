package dnlhng.webtech.dnlhng.web.api;

public class Benutzer {

    private long id;
    private String vorname;
    private String nachname;
    private String studiengang;

    public Benutzer(long id, String vorname, String nachname, String studiengang) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.studiengang = studiengang;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStudiengang() {
        return studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
}
