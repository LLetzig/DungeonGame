import java.sql.*;

public class DBM {
    /**
     * erstellen von Spielstand tabellen, falls nicht vorhanden.
     */
    public  void createTables() {
        String warrior = """
        CREATE TABLE IF NOT EXISTS Warrior (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            maxHealth INTEGER NOT NULL,
            currentHealth INTEGER NOT NULL,
            baseAttack INTEGER NOT NULL,
            lvl INTEGER NOT NULL,
            initiative INTEGER NOT NULL,
            dmg INTEGER,
            maxExp INTEGER NOT NULL,
            currentExp INTEGER NOT NULL,
            strength INTEGER,
            maxArmor INTEGER,
            currentArmor INTEGER
        );
        """;

        String mage = """
        CREATE TABLE IF NOT EXISTS Mage (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            maxHealth INTEGER NOT NULL,
            currentHealth INTEGER NOT NULL,
            baseAttack INTEGER NOT NULL,
            lvl INTEGER NOT NULL,
            initiative INTEGER NOT NULL,
            dmg INTEGER,
            maxExp INTEGER NOT NULL,
            currentExp INTEGER NOT NULL,
            mana INTEGER,
            intelligence INTEGER
        );
        """;

        String rogue = """
        CREATE TABLE IF NOT EXISTS Rogue (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            maxHealth INTEGER NOT NULL,
            currentHealth INTEGER NOT NULL,
            baseAttack INTEGER NOT NULL,
            lvl INTEGER NOT NULL,
            initiative INTEGER NOT NULL,
            dmg INTEGER,
            maxExp INTEGER NOT NULL,
            currentExp INTEGER NOT NULL,
            dexterity INTEGER,
            crit INTEGER,
            evasion INTEGER
        );
        """;

        try (Connection conn = DBH.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(warrior);
            stmt.execute(mage);
            stmt.execute(rogue);

            System.out.println("Tabellen erstellt oder existieren bereits");

        } catch (SQLException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }


    /**
     * Schreibt ein Warriorobjekt in die Warriortabelle
     * @param warrior (player)
     */
    public void insertWarrior(Warrior warrior) {
        String sql = "INSERT INTO Warrior (name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp, strength, maxArmor, currentArmor) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, warrior.getName());
            pstmt.setDouble(2, warrior.getMaxHealth());
            pstmt.setDouble(3, warrior.getCurrentHealth());
            pstmt.setDouble(4, warrior.getBaseAttack());
            pstmt.setInt(5, warrior.getLvl());
            pstmt.setDouble(6, warrior.getInitiative());
            pstmt.setDouble(7, warrior.getDmg());
            pstmt.setInt(8, warrior.getMaxExp());
            pstmt.setInt(9, warrior.getCurrentExp());
            pstmt.setInt(10, warrior.getStrength());
            pstmt.setInt(11, warrior.getMaxArmor());
            pstmt.setInt(12, warrior.getCurrentArmor());

            pstmt.executeUpdate();
            System.out.println("Warrior inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error inserting Warrior: " + e.getMessage());
        }
    }


    /**
     * Schreibt ein Magerobjekt in die Magetabelle
     * @param mage (player)
     */
    public void insertMage(Mage mage) {
        String sql = "INSERT INTO Mage (name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp, mana, intelligence) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, mage.getName());
            pstmt.setDouble(2, mage.getMaxHealth());
            pstmt.setDouble(3, mage.getCurrentHealth());
            pstmt.setDouble(4, mage.getBaseAttack());
            pstmt.setInt(5, mage.getLvl());
            pstmt.setDouble(6, mage.getInitiative());
            pstmt.setDouble(7, mage.getDmg());
            pstmt.setInt(8, mage.getMaxExp());
            pstmt.setInt(9, mage.getCurrentExp());
            pstmt.setInt(10, mage.getMana());
            pstmt.setInt(11, mage.getIntelligence());

            pstmt.executeUpdate();
            System.out.println("Mage inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error inserting Mage: " + e.getMessage());
        }
    }
    /**
     * Schreibt ein Rogueobjekt in die Roguetabelle
     * @param rogue (player)
     */
    public void insertRogue(Rogue rogue) {
        String sql = "INSERT INTO Rogue (name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp, dexterity, crit, evasion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rogue.getName());
            pstmt.setDouble(2, rogue.getMaxHealth());
            pstmt.setDouble(3, rogue.getCurrentHealth());
            pstmt.setDouble(4, rogue.getBaseAttack());
            pstmt.setInt(5, rogue.getLvl());
            pstmt.setDouble(6, rogue.getInitiative());
            pstmt.setDouble(7, rogue.getDmg());
            pstmt.setInt(8, rogue.getMaxExp());
            pstmt.setInt(9, rogue.getCurrentExp());
            pstmt.setInt(10, rogue.getDexterity());
            pstmt.setDouble(11, rogue.getCrit());
            pstmt.setDouble(12, rogue.getEvasion());

            pstmt.executeUpdate();
            System.out.println("Rogue inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error inserting Rogue: " + e.getMessage());
        }
    }

    /**
     * erstellt Warrior Objekt
     * @param id
     * @return Warrior obj
     */
    public Warrior getWarrior(int id) {
        String sql = "SELECT * FROM Warrior WHERE id = ?";
        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Warrior(
                        rs.getString("name"),
                        rs.getDouble("maxHealth"),
                        rs.getDouble("currentHealth"),
                        rs.getDouble("baseAttack"),
                        rs.getInt("lvl"),
                        rs.getDouble("initiative"),
                        rs.getDouble("dmg"),
                        rs.getInt("maxExp"),
                        rs.getInt("currentExp"),
                        rs.getInt("strength"),
                        rs.getInt("maxArmor"),
                        rs.getInt("currentArmor")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Warrior: " + e.getMessage());
        }
        return null;
    }

    /**
     * erstellt Rogueobjekt
     * @param id
     * @return
     */
    public Rogue getRogue(int id) {
        String sql = "SELECT * FROM Warrior WHERE id = ?";
        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Rogue(
                        rs.getString("name"),
                        rs.getDouble("maxHealth"),
                        rs.getDouble("currentHealth"),
                        rs.getDouble("baseAttack"),
                        rs.getInt("lvl"),
                        rs.getDouble("initiative"),
                        rs.getDouble("dmg"),
                        rs.getInt("maxExp"),
                        rs.getInt("currentExp"),
                        rs.getInt("dexterity"),
                        rs.getInt("crit"),
                        rs.getInt("evasion")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Warrior: " + e.getMessage());
        }
        return null;
    }

    /**
     * erstellt Rogueobjekt
     * @param id
     * @return
     */
    public Mage getMage(int id) {
        String sql = "SELECT * FROM Warrior WHERE id = ?";
        try (Connection conn = DBH.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Mage(
                        rs.getString("name"),
                        rs.getDouble("maxHealth"),
                        rs.getDouble("currentHealth"),
                        rs.getDouble("baseAttack"),
                        rs.getInt("lvl"),
                        rs.getDouble("initiative"),
                        rs.getDouble("dmg"),
                        rs.getInt("maxExp"),
                        rs.getInt("currentExp"),
                        rs.getInt("mana"),
                        rs.getInt("intelligence")

                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Warrior: " + e.getMessage());
        }
        return null;
    }

    /**
     * Anzeige aller Spielstände
     */
    public void showAllSaves(){
        String[] tables = {"warrior", "rogue", "mage"};

        try (Connection conn = DBH.connect();
             Statement stmt = conn.createStatement()) {

            for (String table : tables) {
                String query = "SELECT name, lvl FROM " + table;
                try (ResultSet rs = stmt.executeQuery(query)) {
                    System.out.println("=== " + table.toUpperCase() + " ===");

                    int columnCount = rs.getMetaData().getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(table + rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + " | ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



