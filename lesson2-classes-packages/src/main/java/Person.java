public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{")
                .append("name: ")
                .append(name)
                .append(", gender:")
                .append((man) ? "male" : "female")
                .append(", spouse:")
                .append((spouse != null) ? spouse.getName() : "none")
                .append("}");
        return sb.toString();
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife,
     * false otherwise
     */
    public boolean marry(Person person) {
        if (this.spouse == person) return false;
        boolean outherIsMan = person.isMan();
        if (outherIsMan != this.man) {
            if (this.spouse != null) {
                this.spouse.divorce();
                this.divorce();
            }
            if (person.getSpouse() != null) {
                person.getSpouse().divorce();
                person.divorce();
            }
            person.setSpouse(this);
            this.spouse = person;
            return true;
        }
        return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse = null;
            return true;
        }
        return false;
    }
}
