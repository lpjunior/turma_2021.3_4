package projetoCRUDbasico.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projetoCRUDbasico.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoDAO extends DAO {

    private static Logger logger = LoggerFactory.getLogger(AlunoDAO.class);

    public boolean save(Aluno aluno) {
        var sql = "insert into aluno(nome, email, matricula, sexo) values (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setInt(3, aluno.getMatricula());
            pstmt.setString(4, aluno.getSexo());

            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE; // retorna error => 0 | success => 1

        } catch (SQLException e) {
            logger.error("Error on save aluno. Error: {}", e);
            return Boolean.FALSE;
        }
    }

    public List<Aluno> findAll() {

        var alunos = new ArrayList<Aluno>();
        var sql = "select * from aluno";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    alunos.add(setAluno(rs));
                }
            }
        } catch (SQLException e) {
            logger.error("Error on list alunos. Error: {}", e);
            return new ArrayList<>();
        }
        return alunos;
    }

    public Aluno findById(long id) {
        var sql = "select * from aluno where id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? setAluno(rs) : new Aluno();
            }
        } catch (SQLException e) {
            logger.error("Error on find id aluno. Error: {}", e);
            return new Aluno();
        }
    }

    public List<Aluno> findByName(String nome) {
        var alunos = new ArrayList<Aluno>();
        var sql = "select * from aluno where nome like ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, '%' + nome + '%');

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    alunos.add(setAluno(rs));
                }
            }
        } catch (SQLException e) {
            logger.error("Error on list alunos. Error: {}", e);
            return new ArrayList<>();
        }
        return alunos;
    }

    public Aluno findByMatricula(int matricula) {
        var sql = "select * from aluno where matricula = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, matricula);

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? setAluno(rs) : new Aluno();
            }
        } catch (SQLException e) {
            logger.error("Error on find id aluno. Error: {}", e);
            return new Aluno();
        }
    }

    public boolean update(Aluno aluno) {
        var sql = "update aluno set nome = ?, email = ?, matricula = ?, sexo = ? where id  = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setInt(3, aluno.getMatricula());
            pstmt.setString(4, aluno.getSexo());
            pstmt.setInt(5, aluno.getId());

            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;

        } catch (SQLException e) {
            logger.error("Error on save aluno. Error: {}", e);
            return Boolean.FALSE;
        }
    }

    public Aluno findByEmail(String email) {
        var sql = "select * from aluno where email = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? setAluno(rs) : new Aluno();
            }
        } catch (SQLException e) {
            logger.error("Error on find id aluno. Error: {}", e);
            return new Aluno();
        }
    }

    public boolean deleteById(long id) {
        var sql = "delete from aluno where id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            logger.error("Error on delete aluno. Error: {}", e);
            return Boolean.FALSE;
        }
    }

    public boolean deleteAll(List<Aluno> alunos) {
        var sql = "delete from aluno where id in (?)";

        //# workaround(gambiarra) para o MySQL
        String sqlIN = alunos.stream()
                .map(aluno -> String.valueOf(aluno.getId()))
                .collect(Collectors.joining(",", "(", ")"));
        sql = sql.replace("(?)", sqlIN);
        //## workaround(gambiarra) para o MySQL

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

// O método createArrayOf não é suportado pela lib do MySQL
//            var idsInList = alunos.stream().map(Aluno::getId).toList();
//            var idsInArray = conn.createArrayOf("integer", idsInList.toArray());
//            pstmt.setArray(1, idsInArray);
            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            logger.error("Error on delete table aluno. Error: {}", e);
            return Boolean.FALSE;
        }
    }

    private Aluno setAluno(ResultSet rs) throws SQLException {
        return new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getInt("matricula"), rs.getString("sexo"));
    }
}