package projetoCRUDbasico.persist;

import projetoCRUDbasico.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAO {
    private Connection conn;

    public boolean save(Aluno aluno) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into aluno(nome, email, matricula, sexo) values (?, ?, ?, ?)");

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setInt(3, aluno.getMatricula());
            pstmt.setString(4, aluno.getSexo());

            var response = pstmt.executeUpdate(); // retorna error => 0 | success => 1

            if(response != 0)
                return Boolean.TRUE;
            return Boolean.FALSE;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on save aluno. Error: " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public List<Aluno> findAll() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno");
            rs = pstmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while(rs.next()) {
                var aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list alunos. Error: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Aluno findById(long id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno where id = ?");
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            Aluno aluno = new Aluno();
            if(rs.next()){
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
            }
            return aluno;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id aluno. Error: " + e.getMessage());
            return new Aluno();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public List<Aluno> findByName(String nome) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno where nome like ?");
            pstmt.setString(1, '%' + nome + '%');
            rs = pstmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while(rs.next()) {
                var aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list alunos. Error: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Aluno findByMatricula(int matricula) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno where matricula = ?");
            pstmt.setInt(1, matricula);
            rs = pstmt.executeQuery();

            Aluno aluno = new Aluno();
            if(rs.next()){
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
            }
            return aluno;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id aluno. Error: " + e.getMessage());
            return new Aluno();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Aluno findByEmail(String email) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno where email = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            Aluno aluno = new Aluno();
            if(rs.next()){
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
            }
            return aluno;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id aluno. Error: " + e.getMessage());
            return new Aluno();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    //public boolean update(Aluno aluno) {}

    public boolean deleteById(long id) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("delete from aluno where id = ?");
            pstmt.setLong(1, id);

            var response = pstmt.executeUpdate();

            if(response != 0)
                return Boolean.TRUE;
            return Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on delete aluno. Error: " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }

    }

    //public boolean deleteAll() {}
}
