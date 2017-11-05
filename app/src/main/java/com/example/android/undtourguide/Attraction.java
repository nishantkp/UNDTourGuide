package com.example.android.undtourguide;

/**
 * Created by Nishant on 11/4/2017.
 */

public class Attraction {
    private String mAttractionName;
    private String mAttractionAddress;
    private String mAttractionDescription;
    private int mImageResourceId;
    private String mLocationId;
    private double mAttractionRating;

    /**
     * @param attractionName    name of the place
     * @param attractionAddress address of the place
     *                          // @param attractionDescription general description of place
     */
    public Attraction(String attractionName, String attractionAddress) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        //mAttractionDescription = attractionDescription;
    }

    /**
     * @param attractionName        name of the place
     * @param attractionAddress     address of the place
     * @param attractionDescription general description of the place
     * @param imageResourceId       image resource if od the place
     */
    public Attraction(String attractionName, String attractionAddress, String attractionDescription,
                      int imageResourceId) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * @param attractionName        name of the place
     * @param attractionAddress     address of the place
     * @param attractionDescription general description of the place
     * @param imageResourceId       image resource if od the place
     * @param locationId            location detail in form of lattitute and longitude
     */
    public Attraction(String attractionName, String attractionAddress, String attractionDescription,
                      int imageResourceId, String locationId) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
    }

    /**
     * Constructor for details about attraction
     *
     * @param attractionName        name of the place
     * @param attractionAddress     address of the place
     * @param attractionDescription general description of the place
     * @param imageResourceId       image resource if od the place
     * @param locationId            location detail in form of latitude and longitude
     * @param attractionRating      rating for attraction
     */
    public Attraction(String attractionName, String attractionAddress, String attractionDescription,
                      int imageResourceId, String locationId, double attractionRating) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mAttractionRating = attractionRating;
    }

    /**
     * @return get the name of place
     */
    public String getAttractionName() {
        return mAttractionName;
    }

    /**
     * @return get the address of place
     */
    public String getAttractionAddress() {
        return mAttractionAddress;
    }

    /**
     * @return get the general description of place
     */
    public String getAttractionDescription() {
        return mAttractionDescription;
    }

    /**
     * @return get the resource id of image
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return get the location detail of place
     */
    public String getLocationId() {
        return mLocationId;
    }

    /**
     * @return get the rating of a place
     */
    public double getAttractionRating() {
        return mAttractionRating;
    }
}
