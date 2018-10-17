package com.example.barclays.tourguideapp;

public class CustomList {
    private String attractionTitle;
    private String attractionContent;
    private int attractionImage;
    private String attractionUrl;

    private String hotelTitle;
    private String hotelContent;
    private int hotelImage;
    private double starRating;

    private String clubTitle;
    private String clubAddress;
    private String clubHours;
    private String clubPhoneNumber;
    private double clubStarRating;

    /**
     *
     * @param aTitle is the name of the attraction
     * @param aContent is the content related to the attraction
     * @param aImage is the image of the attraction
     * @param aUrl is the website URL of the attraction if any
     */
    public CustomList(String aTitle, String aContent, int aImage, String aUrl){
        this.attractionTitle = aTitle;
        this.attractionContent = aContent;
        this.attractionImage = aImage;
        this.attractionUrl = aUrl;
    }

    public CustomList(String aTitle, String aContent, int aImage){
        this.attractionTitle = aTitle;
        this.attractionContent = aContent;
        this.attractionImage = aImage;
    }

    /**
     *
     * @param hTitle is the name of the hotel
     * @param hImage is the image of the hotel
     * @param hContent is the content related with the hotel
     * @param hStarRating is the rating of the hotel
     */
    public CustomList(String hTitle, int hImage, String hContent, double hStarRating){
        this.hotelTitle = hTitle;
        this.hotelContent = hContent;
        this.hotelImage = hImage;
        this.starRating = hStarRating;
    }

    /**
     *
     * @param clubTitle is the name of the club
     * @param clubAddress is the address of the club
     * @param clubHours are the operating hours of the club
     * @param clubPhoneNumber is the contact number for the club
     * @param clubStarRating is the rating of club
     */
    public CustomList(String clubTitle, String clubAddress, String clubHours, String clubPhoneNumber, double clubStarRating){
        this.clubTitle = clubTitle;
        this.clubAddress = clubAddress;
        this.clubHours = clubHours;
        this.clubPhoneNumber = clubPhoneNumber;
        this.clubStarRating = clubStarRating;
    }

    /**
     *For the attraction fragment
     */
    public String getAttractionTitle() {
        return attractionTitle;
    }

    public String getAttractionContent() {
        return attractionContent;
    }

    public int getAttractionImage() {
        return attractionImage;
    }

    public String getAttractionUrl(){
        return attractionUrl;
    }

    /**
     *For the hotel fragment
     */
    public String getHotelTitle() {
        return hotelTitle;
    }

    public String getHotelContent() {
        return hotelContent;
    }

    public int getHotelImage() {
        return hotelImage;
    }

    public double getStarRating(){
        return starRating;
    }

    /**
     * For the club fragment
     */
    public String getClubTitle() {
        return clubTitle;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public String getClubHours() {
        return clubHours;
    }

    public String getClubPhoneNumber() {
        return clubPhoneNumber;
    }

    public double getClubStarRating() {
        return clubStarRating;
    }

}//end of public class
