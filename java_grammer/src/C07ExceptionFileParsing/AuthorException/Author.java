package C07ExceptionFileParsing.AuthorException;

public class Author {

    private static Long static_id = 0L;

    private Long id;

    private String name;

    private String email;

    private String password;

    public Author(String name, String email, String password) {
        static_id += 1;
        this.id = static_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
