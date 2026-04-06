package com.example;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class App {
  Playwright plw;
  Browser browser;
  Page page;
  BrowserContext context;
  private Path log = Paths.get("resul.log");

  void launchBrowser() {
    plw = Playwright.create();
    browser = plw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
  }

  void InitPage(String url) {
    this.page = this.browser.newPage();
    this.context = browser.newContext();
    this.page.navigate(url);
    this.page.waitForLoadState();
  }

  void Insert(String user, String ps) throws InterruptedException {
    // exemplo da docs
    // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign
    // in")).click();
    /*
     * this.page.locator(
     * "xpath=/html/body/main/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/input[2]")
     * .fill(ps);
     * this.page.locator
     * ("xpath=/html/body/main/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/button[1]")
     * .click();
     * 
     * int e1 = this.page.locator("xpath=/").count();
     * 
     * this.page.locator("#login")
     * .fill(user);
     */

    Thread.sleep(1000);
  }

  void wLog(String tx) throws IOException {
    Files.writeString(log, tx + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
  }

  void CloseBrw() {
    this.browser.close();
  }

  public static void main(String[] args) throws InterruptedException, IOException {
        Path src = Paths.get("input_list.txt");
        try(Stream<String> linhas = Files.lines(src)) {
            linhas.forEach(l -> {
                System.out.println(l.split(":")[0] + " " + l.split(":")[1]);
            });
        }
        
  }
}
