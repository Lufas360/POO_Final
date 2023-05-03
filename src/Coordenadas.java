import java.io.*;

public class Coordenadas implements Serializable {
    int graus_latitude;
    int minutos_latitude;
    int graus_longitude;
    int minutos_longitude;

    public int getGraus_latitude() {
        return graus_latitude;
    }

    public void Coordenadas(int graus_latitude, int minutos_latitude, int graus_longitude, int minutos_longitude) {
        this.graus_latitude = graus_latitude;
        this.minutos_latitude = minutos_latitude;
        this.graus_longitude = graus_longitude;
        this.minutos_longitude = minutos_longitude;
    }

    public void setGraus_latitude(int graus_latitude) {
        this.graus_latitude = graus_latitude;
    }

    public int getMinutos_latitude() {
        return minutos_latitude;
    }

    public void setMinutos_latitude(int minutos_latitude) {
        this.minutos_latitude = minutos_latitude;
    }

    public int getGraus_longitude() {
        return graus_longitude;
    }

    public void setGraus_longitude(int graus_longitude) {
        this.graus_longitude = graus_longitude;
    }

    public int getMinutos_longitude() {
        return minutos_longitude;
    }

    public void setMinutos_longitude(int minutos_longitude) {
        this.minutos_longitude = minutos_longitude;
    }
}
