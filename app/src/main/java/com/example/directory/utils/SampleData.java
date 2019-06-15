package com.example.directory.utils;

import com.example.directory.R;
import com.example.directory.models.UserProfileModel;
import com.example.directory.models.UserContactModel;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static List<UserContactModel> getFavoriteContacts() {
        List<UserContactModel> listModels = new ArrayList<>();

        UserContactModel model = new UserContactModel(1, R.drawable.ic_default_male_user,
                "Abhishek Chhajed", "Ahmedabad", "Udaipur");
        listModels.add(model);

        model = new UserContactModel(2, R.drawable.ic_default_male_user,
                "Akash Bohra", "Bangalore", "Deogarh");
        listModels.add(model);

        model = new UserContactModel(3, R.drawable.ic_default_male_user,
                "Pankaj Shah", "Mumbai", "Rajsamand");
        listModels.add(model);

        model = new UserContactModel(4, R.drawable.ic_default_male_user,
                "Rakesh Kothari", "Ahmedabad", "Lasani");
        listModels.add(model);

        return listModels;
    }

    public static List<UserContactModel> getOtherContacts() {
        List<UserContactModel> listModels = new ArrayList<>();

        UserContactModel model = new UserContactModel(5, R.drawable.ic_default_male_user,
                "Anjali Mandot", "Keral", "Bhim");
        listModels.add(model);

        model = new UserContactModel(6, R.drawable.ic_default_male_user,
                "Ayush Shah", "Delhi", "Kosithal");
        listModels.add(model);

        model = new UserContactModel(7, R.drawable.ic_default_male_user,
                "Bhaomik Katariya", "Udaipur", "Udaipur");
        listModels.add(model);

        model = new UserContactModel(8, R.drawable.ic_default_male_user,
                "Bhavesh Mandot", "Sikandarabad", "Kameri");
        listModels.add(model);

        model = new UserContactModel(9, R.drawable.ic_default_male_user,
                "Chanda Kothari", "Hydrabad", "Madariya");
        listModels.add(model);

        model = new UserContactModel(10, R.drawable.ic_default_male_user,
                "Deven Bohra", "Hydrabad", "Kelva");
        listModels.add(model);

        model = new UserContactModel(11, R.drawable.ic_default_male_user,
                "Hardik Bohra", "Bangalore", "Baghana");
        listModels.add(model);

        model = new UserContactModel(12, R.drawable.ic_default_male_user,
                "Niraj Jain", "Ahmedabad", "Baghana");
        listModels.add(model);

        model = new UserContactModel(13, R.drawable.ic_default_male_user,
                "Sandeep Jain", "Ahmedabad", "Baghana");
        listModels.add(model);

        model = new UserContactModel(14, R.drawable.ic_default_male_user,
                "Suraj Bohra", "Ahmedabad", "Baghana");
        listModels.add(model);

        model = new UserContactModel(15, R.drawable.ic_default_male_user,
                "Varun Mehta", "Pune", "Bhilwara");
        listModels.add(model);

        model = new UserContactModel(16, R.drawable.ic_default_male_user,
                "Vivek Samra", "Mumbai", "Gangapur");
        listModels.add(model);
        return listModels;
    }

    public static UserProfileModel createDataList() {
        UserProfileModel userProfile = new UserProfileModel(1, "Hardik Bohra",
                "Uttamkumar Bohra", R.drawable.hardik, "14/06/1994",
                "Baghana", "Bangalore");
        userProfile.setHomeAddressLine1("#59/1, 367, 2nd floor");
        userProfile.setHomeAddressLine2("13th main, near HDFC ATM");
        userProfile.setHomeAddressLine3("Virat nagar road, Bommanhalli");
        userProfile.setHomeAddressCity("Bangalore");
        userProfile.setHomeAddressState("Karnataka");
        userProfile.setHomeAddressPincode("560068");
        userProfile.setOccupation("Software Engineer");
        userProfile.setOfficeAddressLine1("Nuclei, 5th floor, Tower-D");
        userProfile.setOfficeAddressLine2("IBC Knowledge Park");
        userProfile.setOfficeAddressLine3("Near Dairy Circle");
        userProfile.setOfficeAddressCity("Bangalore");
        userProfile.setOfficeAddressState("Karnataka");
        userProfile.setOfficeAddressPincode("560068");
        userProfile.setContactNumber("+91-8306794666");
        userProfile.setContactNumber2("+91-8320716555");
        userProfile.setEmail("hardik.bohra@gmail.com");

        return userProfile;
    }
}
