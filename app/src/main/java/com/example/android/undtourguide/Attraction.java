package com.example.android.undtourguide;

/**
 * Custom class for store and get details about attraction
 * Created by Nishant on 11/4/2017.
 */

public class Attraction {
    private static final String NO_PHONE_NUMBER = "0";
    private String mAttractionName;
    private String mAttractionAddress;
    private String mAttractionDescription;
    private int mImageResourceId;
    private String mLocationId;
    private double mAttractionRating;
    private String mAttractionPhoneNumber = NO_PHONE_NUMBER;
    private int mThumbnailResourceId;

    /**
     * Constructor for details about attraction
     *
     * @param attractionName        name of the place
     * @param attractionAddress     address of the place
     * @param attractionDescription general description of the place
     * @param imageResourceId       image resource id of the place
     * @param locationId            location detail in form of latitude and longitude
     * @param attractionRating      rating for attraction
     * @param thumbnailResourceID   thumbnail resource id of the place
     */
    public Attraction(String attractionName
            , String attractionAddress
            , String attractionDescription
            , int imageResourceId
            , String locationId
            , double attractionRating
            , int thumbnailResourceID) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mAttractionRating = attractionRating;
        mThumbnailResourceId = thumbnailResourceID;
    }

    /**
     * Constructor for details about attraction
     *
     * @param attractionName        name of the place
     * @param attractionAddress     address of the place
     * @param attractionDescription general description of the place
     * @param imageResourceId       image resource id of the place
     * @param locationId            location detail in form of latitude and longitude
     * @param attractionRating      rating for attraction
     * @param attractionPhoneNumber phone number of place
     * @param thumbnailResourceId   thumbnail resource id of the place
     */
    public Attraction(String attractionName
            , String attractionAddress
            , String attractionDescription
            , int imageResourceId
            , String locationId
            , double attractionRating
            , String attractionPhoneNumber, int thumbnailResourceId) {
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mAttractionRating = attractionRating;
        mAttractionPhoneNumber = attractionPhoneNumber;
        mThumbnailResourceId = thumbnailResourceId;
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

    /**
     * @return get the phone number of a place
     */
    public String getAttractionPhoneNumber() {
        return mAttractionPhoneNumber;
    }

    /**
     * @return true if phone number is present, else return false
     */
    public boolean hasPhoneNumber() {
        return !(mAttractionPhoneNumber.equals(NO_PHONE_NUMBER));
    }

    /**
     * @return get the resource id of thumbnail
     */
    public int getThubmnailResourceId() {
        return mThumbnailResourceId;
    }
}
