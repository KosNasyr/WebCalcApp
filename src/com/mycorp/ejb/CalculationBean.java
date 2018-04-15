package com.mycorp.ejb;

import com.mycorp.model.CalcLog;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CalculationBean {

    @Resource(lookup = "jdbc/TestDB")
    DataSource ds;

    public double calculate(double a, double b, String operator){
        double result;
        char oper = operator.charAt(0);
        switch (oper){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
            default:
                result = calculate(a, b,operator);
        }
        return result;
    }

    public void createCalculationLog(CalcLog calcLog){
        final String q ="INSERT INTO calculation_log(param1,param2,result,operation) VALUES (?,?,?,?)";
        try (Connection c = ds.getConnection();
             PreparedStatement ps = createLogStatement(c, q, calcLog)) {
             ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    private static PreparedStatement createLogStatement(final Connection c,
                                                                   final String q,
                                                                   final CalcLog calcLog) throws SQLException {
        PreparedStatement ps = c.prepareStatement(q);
        ps.setDouble(1, calcLog.getParam1());
        ps.setDouble(2, calcLog.getParam2());
        ps.setDouble(3, calcLog.getResult());
        ps.setString(4, calcLog.getOperation());

        return ps;
    }

    public List<CalcLog> getCalcLog(){
        final List<CalcLog> list = new ArrayList<>();
        try(Connection conn = ds.getConnection()) {
            String sql = "SELECT * FROM calculation_log ORDER BY id DESC LIMIT 10";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                list.add(new CalcLog(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getDate(6)));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }

}
