package exercise.one;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 1
 */

public class AddressBook {

	private String businessPhone;
	private String cellPhone;
	private String facebookId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String homeAddress;
	private String homePhone;
	private String personalWebSite;
	private String skypeId;

	public AddressBook() {
	}

	public AddressBook(String businessPhone, String cellPhone, String facebookId, String firstName, String middleName, String lastName, String homeAddress, String homePhone, String personalWebSite, String skypeId) {
		this.setBusinessPhone(businessPhone);
		this.setCellPhone(cellPhone);
		this.setFacebookId(facebookId);
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
		this.setHomeAddress(homeAddress);
		this.setHomePhone(homePhone);
		this.setPersonalWebSite(personalWebSite);
		this.setSkypeId(skypeId);
	}

	public AddressBook(String firstName) {
		this.setFirstName(firstName);
	}

	public AddressBook(String firstName, String middleName) {
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
	}

	public AddressBook(String firstName, String middleName, String lastName) {
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getPersonalWebSite() {
		return personalWebSite;
	}

	public void setPersonalWebSite(String personalWebSite) {
		this.personalWebSite = personalWebSite;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/*
	** Pass in two strings (according to API) and will return
	** a String based on equality of the String parameters.
	 */
	public static String compareNames(String name1, String name2) {

		if (name1.equals(name2)) {
			return "They match!";
		} else {
			return "Does not match";
		}
	}

	public static void main(String[] args) {
		//Creating two identical entries for testing
		AddressBook bookOne = new AddressBook();
		AddressBook bookTwo = new AddressBook();

		bookOne.setFirstName("test ");
		bookOne.setMiddleName("T. ");
		bookOne.setLastName("last");
		String nameOne = bookOne.getFirstName()
				+ bookOne.getMiddleName()
				+ bookOne.getLastName();

		bookTwo.setFirstName("test ");
		bookTwo.setMiddleName("T. ");
		bookTwo.setLastName("last");
		String nameTwo = bookTwo.getFirstName()
				+ bookTwo.getMiddleName()
				+ bookTwo.getLastName();

		System.out.println(AddressBook.compareNames(nameOne, nameTwo));

	}

}
