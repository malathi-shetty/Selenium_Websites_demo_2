package automatePDFFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_PDF_File {

	public WebDriver driver;
	String url = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";

	@BeforeMethod()
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(priority = 0)
	public void pdfAutomateTesting() throws IOException {
		// Class URL represets a Uniform Resource Locator, a pointer to a "resource" on
		// the WorldWideWeb.
		URL pdfURl = new URL(url);

		// Opens a connection to this URL and returns an InputStream for reading from
		// that connection.
		InputStream ips = pdfURl.openStream();

		// Creates a BufferedInputStream and saves its argument, the inputStream in, for
		// later use.
		BufferedInputStream bf = new BufferedInputStream(ips);

		// This is the in-memory representation of the PDF document
		PDDocument pd = PDDocument.load(bf);

		// page count
		int pdfPages = pd.getNumberOfPages();
		System.out.println("Number of Pages: " + pdfPages);

		// extract text from the pdf file
		PDFTextStripper pdfStr = new PDFTextStripper();
		String capturedText = pdfStr.getText(pd);
		System.out.println("Captured Text: " + capturedText);

		// validate the text in the pdf file
		Assert.assertTrue(capturedText.contains("PDF BOOKMARK SAMPLE"));
		Assert.assertTrue(capturedText.contains("The template targeted for PDF output."));

		// This will close the underlying COSDocument object.
		pd.close();
		bf.close(); // Also close BufferedInputStream
		ips.close(); // Close InputStream

	}

	@AfterMethod()
	public void tearDown() {

		try {
			if (driver != null) {
				driver.quit(); // Quit the driver
			}
		} catch (Exception e) {
			e.printStackTrace(); // Log or handle exceptions
		} finally {
			driver = null; // Clear the driver reference
		}

	}

}

// Note had to Downgrade to PDFBox 2.0.24 if issues persist with version 3.0.3.

// Apache PDFBox version 3.0.3, which does not have the load(InputStream) method that was available in earlier versions