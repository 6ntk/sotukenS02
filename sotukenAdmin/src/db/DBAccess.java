package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAccess
{
  private String driver;
  private Connection con;
  private Statement stmt;
  private PreparedStatement pstmt;
  private ResultSet rsResult;
  private int intResult;

  public DBAccess(String driver)
  {
    this.driver = driver;
  }

  public PreparedStatement getPstmt()
  {
    return this.pstmt;
  }

  public ResultSet getRsResult()
  {
    return this.rsResult;
  }

  public int getIntResult()
  {
    return this.intResult;
  }

  //接続
  public void connect()
    throws Exception
  {
    InitialContext initCon = new InitialContext();
    DataSource ds = (DataSource)initCon.lookup(this.driver);
    this.con = ds.getConnection();
  }

  //切断
  public void disConnect()
    throws SQLException
  {
    if (this.rsResult != null)
    {
      this.rsResult.close();
      this.rsResult = null;
    }
    if (this.stmt != null)
    {
      this.stmt.close();
      this.stmt = null;
    }
    if (this.pstmt != null)
    {
      this.pstmt.close();
      this.pstmt = null;
    }
    if (this.con != null)
    {
      this.con.close();
      this.con = null;
    }
  }


  public void createStatement()
    throws SQLException
  {
    if (this.con != null) {
      this.stmt = this.con.createStatement();
    }
  }

  public void createStatement(String sql)
    throws SQLException
  {
    if (this.con != null) {
      this.pstmt = this.con.prepareStatement(sql);
    }
  }

  public void selectExe()
    throws SQLException
  {
    if (this.pstmt != null)
    {
      this.rsResult = null;
      this.rsResult = this.pstmt.executeQuery();
    }
  }

  public void selectExe(String sql)
    throws SQLException
  {
    if (this.stmt != null)
    {
      this.rsResult = null;
      this.rsResult = this.stmt.executeQuery(sql);
    }
  }


  public void updateExe()
    throws SQLException
  {
    if (this.pstmt != null)
    {
      this.intResult = 0;
      this.intResult = this.pstmt.executeUpdate();
    }
  }

  public void updateExe(String sql)
    throws SQLException
  {
    if (this.stmt != null)
    {
      this.intResult = 0;
      this.intResult = this.stmt.executeUpdate(sql);
    }
  }
}
