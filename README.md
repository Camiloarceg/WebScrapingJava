# WebScrapingJava 🚀

A simple Java web-scraping project that extracts data from a dummy e‑commerce page and saves it into JSON format. This project also includes a Postman collection to demonstrate basic GET/POST usage using the output data—ideal for technical interview demos or quick API testing.

---

## 🛠 Prerequisites

- Java 8+ (JDK installed)
- Maven 3.x
- Git (for cloning)
- Postman (desktop or web)
- Internet access to scrape the dummy site

---

- This will:
  - Access the dummy e‑commerce page.
  - Parse product details (e.g. name, price, description).
  - Save results to **data/output.json**.

### 3. Inspect the output

Open `data/output.json` in your editor. It should look like:

```json
[
  {
    "name": "Product A",
    "price": 19.99,
    "description": "An example product."
  },
  {
    "name": "Product B",
    "price": 29.99,
    "description": "Another example product."
  }
]
```

---
