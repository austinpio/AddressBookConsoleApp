package test.austin;


import com.austin.entities.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AddressBookTest {

    private AddressBook addressBook;

    private ByteArrayOutputStream outputStream=new ByteArrayOutputStream();

    @Before
    public void setup(){
        addressBook=new AddressBook();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void addressBookItem_addItem_NewItemAdded() {
        AddressBookItem addressBookItem=mockAddressBookItem();
        addressBookItem = addressBook.addAddressBookItem(addressBookItem);
        assertThat(addressBookItem).isNotNull();
        assertThat(addressBookItem.getPerson().getName()).isEqualToIgnoringCase("austin");
    }

    @Test
    public void printAddressBook_givenAddressBook_printsAllEntries(){
        addressBook.addAddressBookItem(mockAddressBookItem());

        addressBook.printAddressBook();
        assertThat(outputStream.toString()).contains("austin");
    }

    private AddressBookItem mockAddressBookItem(){
        AddressBookItem addressBookItem=new AddressBookItem();

        Person person=new Person();
        person.setName("austin");
        addressBookItem.setPerson(person);
        PhoneNumber phoneNumber=new PhoneNumber();
        phoneNumber.setPhoneNumber("+64211804190");
        phoneNumber.setType(PhoneNumberType.MOBILE);
        List<PhoneNumber>phoneNumbers=new ArrayList<PhoneNumber>();
        addressBookItem.setPhoneNumbers(phoneNumbers);

        return addressBookItem;
    }
}
