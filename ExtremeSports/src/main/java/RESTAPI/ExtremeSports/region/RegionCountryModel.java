package RESTAPI.ExtremeSports.region;

public class RegionCountryModel {
    public Region region;
    public Long countryId;

    public RegionCountryModel() {}

    public RegionCountryModel(Region region, Long countryId) {
        this.region = region;
        this.countryId = countryId;
    }
}
