package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the Automation Exercise products page.
 * Contains all element locators and targets for the products page.
 */
public final class ProductsPage {

  private ProductsPage() {
    // Utility class - prevent instantiation
  }

  // Navigation to products page
  public static final Target PRODUCTS_LINK = Target
      .the("products link")
      .located(By.cssSelector("a[href='/products']"));

  // Products section
  public static final Target PRODUCTS_SECTION = Target
      .the("products section")
      .located(By.cssSelector(".features_items"));

  public static final Target ALL_PRODUCTS_TITLE = Target
      .the("all products title")
      .located(By.xpath("//h2[contains(text(), 'All Products')]"));

  // Product items - simplified selectors
  public static final Target FIRST_PRODUCT = Target
      .the("first product")
      .located(By.cssSelector(".col-sm-4:first-child"));

  public static final Target SECOND_PRODUCT = Target
      .the("second product")
      .located(By.cssSelector(".col-sm-4:nth-child(2)"));

  // Add to cart buttons - simplified approach
  public static final Target FIRST_PRODUCT_ADD_TO_CART = Target
      .the("first product add to cart button")
      .located(By.xpath("(//a[contains(@class, 'add-to-cart')])[1]"));

  public static final Target SECOND_PRODUCT_ADD_TO_CART = Target
      .the("second product add to cart button")
      .located(By.xpath("(//a[contains(@class, 'add-to-cart')])[2]"));

  // Generic add to cart buttons for any product
  public static final Target ANY_ADD_TO_CART_BUTTON = Target
      .the("any add to cart button")
      .located(By.cssSelector(".add-to-cart"));

  // Continue shopping modal
  public static final Target CONTINUE_SHOPPING_BUTTON = Target
      .the("continue shopping button")
      .located(By.xpath("//button[contains(text(), 'Continue Shopping')]"));

  public static final Target VIEW_CART_MODAL_LINK = Target
      .the("view cart modal link")
      .located(By.xpath("//a[contains(text(), 'View Cart')]"));

  public static final Target MODAL_BODY = Target
      .the("modal body")
      .located(By.cssSelector(".modal-body"));

  public static final Target MODAL_CLOSE_BUTTON = Target
      .the("modal close button")
      .located(By.cssSelector(".modal-header button.close"));

  public static final Target VIEW_CART_LINK = Target
      .the("view cart link")
      .located(By.cssSelector("a[href='/view_cart']"));

  // Product overlay
  public static final Target PRODUCT_OVERLAY = Target
      .the("product overlay")
      .located(By.cssSelector(".product-overlay"));

  // Alternative selectors for products
  public static final Target PRODUCTS = Target
      .the("all products")
      .located(By.cssSelector(".single-products"));
}
