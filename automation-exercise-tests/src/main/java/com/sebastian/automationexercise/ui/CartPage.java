package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the Automation Exercise shopping cart page.
 * Contains all element locators and targets for the cart page.
 */
public final class CartPage {

  private CartPage() {
    // Utility class - prevent instantiation
  }

  // Cart navigation
  public static final Target CART_LINK = Target
      .the("cart link")
      .located(By.cssSelector("a[href='/view_cart']"));

  // Cart page elements
  public static final Target CART_PAGE_TITLE = Target
      .the("cart page title")
      .located(By.xpath("//li[contains(text(), 'Shopping Cart')]"));

  public static final Target CART_INFO_TABLE = Target
      .the("cart info table")
      .located(By.cssSelector("#cart_info_table, .cart_info"));

  // More flexible cart detection
  public static final Target CART_SECTION = Target
      .the("cart section")
      .located(By.cssSelector(".cart_info, #cart_info_table, .table-responsive"));

  public static final Target ANY_CART_CONTENT = Target
      .the("any cart content")
      .located(By.xpath("//*[contains(@class, 'cart') or contains(@id, 'cart')]"));

  // Cart items
  public static final Target CART_ITEMS = Target
      .the("cart items")
      .located(By.cssSelector("#cart_info_table tbody tr, .cart_info_table tbody tr"));

  public static final Target FIRST_CART_ITEM = Target
      .the("first cart item")
      .located(By.cssSelector("#cart_info_table tbody tr:first-child, "
          + ".cart_info_table tbody tr:first-child"));

  public static final Target SECOND_CART_ITEM = Target
      .the("second cart item")
      .located(By.cssSelector("#cart_info_table tbody tr:nth-child(2), "
          + ".cart_info_table tbody tr:nth-child(2)"));

  // Product details in cart
  public static final Target PRODUCT_NAME = Target
      .the("product name")
      .located(By.cssSelector(".cart_description h4 a, td.cart_description h4 a"));

  public static final Target PRODUCT_PRICE = Target
      .the("product price")
      .located(By.cssSelector(".cart_price p, td.cart_price p"));

  public static final Target PRODUCT_QUANTITY = Target
      .the("product quantity")
      .located(By.cssSelector(".cart_quantity button, td.cart_quantity button"));

  // Delete buttons
  public static final Target DELETE_FIRST_ITEM = Target
      .the("delete first item button")
      .located(By.xpath("(//a[contains(@class,'cart_quantity_delete')])[1]"));

  public static final Target DELETE_SECOND_ITEM = Target
      .the("delete second item button")
      .located(By.xpath("(//a[contains(@class,'cart_quantity_delete')])[2]"));

  // Empty cart message
  public static final Target EMPTY_CART_MESSAGE = Target
      .the("empty cart message")
      .located(By.cssSelector("#empty_cart"));

  // Cart summary
  public static final Target CART_TOTAL = Target
      .the("cart total")
      .located(By.cssSelector(".cart_total_price"));
}
