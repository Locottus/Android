package mgis.dbtracker.herlich.dbplotter;

import android.location.Location;
import android.os.Bundle;

/**
 * Created by herlich on 2/24/2018.
 */

public class MyLocationService  implements android.location.LocationListener  {


    public  double latitud;
    public  double longitud;
    public  float velocidad;
    public  double altitud;
    public  long tiempo;
    public float exactitud;


    @Override
    public void onLocationChanged(Location location) {

        longitud =location.getLongitude();
        latitud  = location.getLatitude();
        velocidad = location.getSpeed();
        altitud = location.getAltitude();
        tiempo = location.getTime();
        exactitud = location.getAccuracy();


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
