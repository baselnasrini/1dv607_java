package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DAO {
    public static ArrayList<Member> arrayList;

    /*
    "Controller should be only responsible for changing the state of model layer.
    DAOs are part of persistence mechanism." - mefisto, stackexchange.com

    This class handles the persistence (storage) of models to a file on the hard drive.
    JSON is used here. JAAAAAASOOOOOOOOOOOOOON!!!

     */

    public boolean readFromFile() {
        try (Reader reader = new BufferedReader(new FileReader("Registry.json"))) {

            Gson gson = new Gson();
            arrayList = gson.fromJson(reader, new TypeToken<ArrayList<Member>>() {}.getType());

            if (arrayList == null) {
                arrayList = new ArrayList<Member>(2);
            }

            return true;
        } catch (IOException f) {
            f.printStackTrace();
            return false;
        }
    }

    public void writeToFile(ArrayList<Member> memberList) {
        try (Writer writer = new FileWriter("Registry.json")) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            gson.toJson(memberList, writer);
        }
        catch (IOException e) {
            System.err.println("Failed to write JSON");
        }
    }

    public boolean writeMemberToFile(Member member) {

        readFromFile();

        arrayList.add(member);
        writeToFile(arrayList);

        return true;

    }

    public boolean updateMemberInFile(Member member) {
        return false;
    }

    public boolean deleteMemberFromFile(Member member) {
        return false;
    }

}
