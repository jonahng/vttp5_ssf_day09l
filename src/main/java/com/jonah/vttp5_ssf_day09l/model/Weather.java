package com.jonah.vttp5_ssf_day09l.model;

public class Weather {
    public String country;
    public String latitude;
    public String longitude;

    

    public Weather() {
    }


    

    public Weather(String country, String latitude, String longitude) {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    

    @Override
    public String toString() {
        return "Weather [country=" + country + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }




    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        return result;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Weather other = (Weather) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        return true;
    }

    
    
}
