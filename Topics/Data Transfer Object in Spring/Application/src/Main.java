class AuthorStatsDTO {
    private long id;
    private String name;
    private int blogsNumber;

    // Constructor that accepts a User instance
    public AuthorStatsDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.blogsNumber = user.getBlogs() != null ? user.getBlogs().size() : 0;
    }

    // Getters and setters for all fields
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlogsNumber() {
        return blogsNumber;
    }

    public void setBlogsNumber(int blogsNumber) {
        this.blogsNumber = blogsNumber;
    }
}
