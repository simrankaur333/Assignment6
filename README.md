# Assignment 6 – SE333 UI Testing

**GitHub Repository:** [https://github.com/simrankaur333/Assignment6](https://github.com/simrankaur333/Assignment6)

This repository contains two sets of UI tests for the DePaul Bookstore website, implemented using Java and Playwright. The goal is to compare **manual test scripting** versus **AI-assisted test generation** using Playwright MCP.

---

## Project Structure

- `test.java.playwrightTraditional` – Traditional manual UI tests written in Java using Playwright.
- `test.java.playwrightLLM` – AI-assisted UI tests generated using natural language prompts with Playwright MCP.

Videos of test execution are recorded under the `videos/` folder.

---

## GitHub Actions

A GitHub Actions workflow is configured to automatically run all UI tests on every push. The workflow runs `mvn test` to execute both packages.

> Note: The traditional test package passes successfully. The AI-assisted test compiles but exhibits minor differences in workflow due to automated element selection (for example, `getByPlaceholder` versus AI-chosen steps). The workflow is configured to **compile both packages**.

---

## Manual UI Testing – `playwrightTraditional`

- Tests are written manually in Java using Playwright.
- Full user workflow is automated: searching for items, filtering, adding to cart, applying promo codes, proceeding to guest checkout, and removing products.
- Videos are recorded to demonstrate the complete flow.

---

## AI-Assisted UI Testing – `playwrightLLM`

- Tests are generated using natural language prompts through Playwright MCP.
- Workflow mirrors the traditional test, but guest checkout information uses distinct values:
   - First Name: `AI`
   - Last Name: `Tester`
   - Email: `ai_test@example.com`
   - Phone: `9876543210`
- Differences from traditional testing are in element selection. For example, AI sometimes chooses `getByText` or keyboard interactions differently.
- All steps are automated, and videos are recorded for comparison.

---

## Reflection

**Ease of Writing:**  
Manual tests require detailed coding for every action; AI-assisted tests can generate complete workflows from natural language prompts, which is faster.

**Accuracy and Reliability:**  
Manual tests are fully predictable and reliable. AI-assisted tests may occasionally misinterpret element selection or interaction methods, which can result in minor failures if strict locators aren’t used.

**Maintenance Effort:**  
Manual tests require more effort to update when the website changes. AI-assisted tests can quickly regenerate flows but may need adjustment for precise element interactions.

**Limitations:**
- AI-assisted tests sometimes choose different element selectors than expected, which can cause test failures if strict validation is needed.
- Both approaches require proper handling of dynamic elements, page loading, and timing.

**Conclusion:**  
Manual UI testing provides maximum control and reliability, whereas AI-assisted testing demonstrates the potential for rapid generation and iteration. Combining both approaches can reduce development time while maintaining accuracy.
