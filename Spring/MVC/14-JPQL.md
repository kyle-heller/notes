### Implementing a Search Bar with JPQL in Spring MVC

In this tutorial, we're enhancing our Spring MVC application by adding a search bar, leveraging the Java Persistence Query Language (JPQL) for more refined database queries. This addition will streamline finding specific items, like running clubs in our app, without needing intricate filter buttons.

#### Introduction to JPQL

JPQL allows for the creation of database queries using an object-oriented query language, making it easier to write, maintain, and optimize queries directly within the application code. By utilizing the `@Query` annotation, developers can embed custom JPQL queries in repository interfaces, offering a fine-tuned approach to data retrieval.

#### Steps to Implement the Search Bar

**1. Define a Custom Repository Method with JPQL**

First, annotate a method in your repository with `@Query`, including your JPQL statement. This example demonstrates a search functionality where we're looking for running clubs with titles similar to the user's query:

```java
@Query("SELECT c FROM Club c WHERE c.title LIKE %:query%")
List<Club> searchClubs(@Param("query") String query);
```

- `SELECT c FROM Club c`: Fetches club entities.
- `WHERE c.title LIKE %:query%`: Filters clubs whose titles contain the search query.
- `:query`: A parameterized part of the query that will be replaced with the actual search term.

**2. Service Layer Method**

Implement a method in your service layer that calls the custom repository method, passing the search query received from the controller:

```java
public List<ClubDto> searchClubs(String query) {
    List<Club> clubs = clubRepository.searchClubs(query);
    return clubs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
}
```

**3. Controller Endpoint for Search**

Create a controller method that handles the search request. Use `@RequestParam` to capture the search query from the URL:

```java
@GetMapping("/clubs/search")
public String searchClubs(@RequestParam("query") String query, Model model) {
    List<ClubDto> clubs = clubService.searchClubs(query);
    model.addAttribute("clubs", clubs);
    return "clubs_list";
}
```

**4. Adding the Search Form to the View**

In the view where you list clubs (`clubs_list.html`), add a form for the search functionality. This form should submit the search query to the controller endpoint defined above:

```html
<form th:action="@{/clubs/search}" method="get">
  <input
    type="search"
    name="query"
    class="form-control"
    placeholder="Search running clubs"
  />
  <button type="submit" class="btn btn-primary">Search</button>
</form>
```

#### Security and Performance Considerations

- **Prevent SQL Injection**: Using `@Param` in JPQL protects against SQL injection by ensuring user input is treated as a parameter rather than part of the SQL statement.
- **Optimize Performance**: Large datasets or complex queries may require additional optimizations, such as indexing, to ensure the application remains responsive.
- **Limit Search Results**: Consider implementing pagination or limiting the number of search results returned to improve performance and usability.

#### Conclusion

Integrating a search bar with JPQL into a Spring MVC application enhances user experience by allowing efficient data retrieval. By following the outlined steps, developers can implement a powerful search feature, ensuring users can quickly find specific items in the application. Remember to consider security and performance implications when designing and implementing your search functionality.
