### Implementing Layouts in Spring MVC with Thymeleaf

Creating a cohesive and visually appealing web application in Spring MVC often requires more than just functional components; it necessitates a consistent layout across different pages. This tutorial outlines how to implement a master layout in Spring MVC using Thymeleaf, ensuring a uniform look and feel across your application.

#### Adding Thymeleaf Layout Dialect Dependency

To enable layout support in Thymeleaf, first, ensure the Thymeleaf Layout Dialect dependency is added to your `pom.xml` file. This addition allows the use of layout features such as defining a master template that other views can inherit from.

```xml
<dependency>
    <groupId>nz.net.ultraq.thymeleaf</groupId>
    <artifactId>thymeleaf-layout-dialect</artifactId>
    <version>YourDesiredVersion</version>
</dependency>
```

#### Creating the Master Layout

1. **Layout File**: Inside your `templates` directory, create a `layout.html` file. This file serves as the master template for your application.
2. **Thymeleaf Namespace**: Ensure your layout file includes the Thymeleaf namespace declaration to enable Thymeleaf processing.

3. **Layout Namespace**: Also, include the layout namespace declaration specific to the Thymeleaf Layout Dialect. This allows you to use layout-specific attributes.

4. **Structure Your Layout**: Define sections in your layout for common elements like headers, navigation bars, footers, and where page-specific content will be injected. Use the `layout:fragment` attribute to designate areas where the content of other templates will be inserted.

#### Integrating Bootstrap for Styling

- **CSS and JavaScript**: Include links to Bootstrap's CSS and JavaScript files in your master layout to ensure consistent styling and functionality across all pages. You can host these files locally within the `static` directory or use CDN links.

#### Defining Page Templates

1. **Page Template Setup**: When creating or editing a page template (e.g., `clubslist.html`), specify that it uses the master layout by adding a `layout:decorate` attribute to the `<html>` tag, pointing to the master layout file.

2. **Content Fragment**: In the page template, wrap the content that should be injected into the master layout with a `layout:fragment="body"` attribute. The value "body" corresponds to the fragment name defined in your master layout.

#### Serving Static Assets

- Place static resources like CSS, JavaScript, and images in the `src/main/resources/static` directory. Thymeleaf and Spring MVC automatically serve files from this location as static web resources, making them accessible in your templates.

#### Example Usage

- **Navbar and Footer**: In the master layout, define the HTML for a navbar and footer. These elements will appear on every page that uses the layout.

- **Content Injection**: Through the use of the `layout:fragment` attribute in your master layout and the corresponding `layout:decorate` and `layout:fragment` in page templates, content from individual pages is seamlessly injected into the defined areas of the master layout.

#### Testing Your Layout

After setting up the master layout and configuring your page templates to use it, run your application and navigate through your pages. You should see a consistent header, navbar, and footer across pages, with the specific content of each page displayed in the designated content area.

#### Conclusion

Implementing a master layout in Spring MVC with Thymeleaf simplifies the management of common page elements, ensuring a uniform user interface across your application. By centralizing the design elements in a single layout file, you minimize redundancy and streamline the development process, making your application easier to maintain and extend.
