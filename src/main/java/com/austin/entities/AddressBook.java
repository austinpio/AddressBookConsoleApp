package com.austin.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBook {

    private List<AddressBookItem> addressBookItems;

    public AddressBook(){
        this.addressBookItems=new ArrayList<>();
    }

    /**
     * Add Item to AddressBook
     * @param addressBookItem
     * @return
     */
    public AddressBookItem addAddressBookItem(AddressBookItem addressBookItem) {
        addressBookItems.add(addressBookItem);
        return addressBookItem;
    }

    /**
     * Prints address book sorted by name
     */
    public void printAddressBook() {

        addressBookItems.stream()
                .sorted(Comparator.comparing(addressBookItem -> addressBookItem.getPerson().getName()))
                .forEach(System.out::println);
    }

}
