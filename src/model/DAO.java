package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DAO {

    /*
    "Controller should be only responsible for changing the state of model layer.
    DAOs are part of persistence mechanism." - mefisto, stackexchange.com

    This class handles the persistence (storage) of models to a file on the hard drive.
    JSON is used here. JAAAAAASOOOOOOOOOOOOOON!!!

     */

    public void writeToFile(Member member) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        System.out.println(gson.toJson(member));
    }
}
