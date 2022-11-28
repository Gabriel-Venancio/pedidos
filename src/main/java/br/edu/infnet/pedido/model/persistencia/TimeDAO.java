package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Time;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO extends JdbcDAO<Time>{

    public TimeDAO(){
    }

    @Override
    public Boolean salvar(Time time) {
        String sql = "insert into time(nome, vitorias, derrotas, empates) values (?,?,?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, time.getNome());
            pstm.setInt(2, time.getDerrotas());
            pstm.setInt(3, time.getDerrotas());
            pstm.setInt(4, time.getEmpates());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean atualizar(Time time) {
        String sql = "update time set nome = ? , vitorias = ?, derrotas = ?, empates = ? where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, time.getNome());
            pstm.setInt(2, time.getDerrotas());
            pstm.setInt(3, time.getDerrotas());
            pstm.setInt(4, time.getEmpates());
            pstm.setLong(5, time.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Time time) {
        String sql = "delete from time where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, time.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Time obter(Long codigo) {
        String sql = "select * from time where codigo = ?";
        Time time = new Time();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()) {
                String nome = rs.getString("nome");
                Integer vitorias = rs.getInt("vitorias");
                Integer derrotas = rs.getInt("derrotas");
                Integer empates = rs.getInt("empates");
                Long codigoDb = rs.getLong("codigo");
                time = new Time(nome, vitorias, derrotas, empates, codigoDb);
            }
            return time;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Time> listarTodos() {
        String sql = "select * from time";
        List<Time> times = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                String nome = rs.getString("nome");
                Integer vitorias = rs.getInt("vitorias");
                Integer derrotas = rs.getInt("derrotas");
                Integer empates = rs.getInt("empates");
                Long codigo = rs.getLong("codigo");
                Time time = new Time(nome, vitorias, derrotas, empates, codigo);
                times.add(time);
            }
            return times;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
