import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table (name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee>employees;

    public City() {

    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId(int i) {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && cityName == city.cityName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name=" + cityName +
                '}';
    }


}