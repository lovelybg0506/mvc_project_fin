package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.project.dto.BoardVO;

public class BoardDAO {
	
	private BoardDAO() {
		
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {

		return instance;
	}
	
	//커넥션 풀 설정
	Connection getConnection() {
		Connection conn = null;
		Context initContext;

		try {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	//유저 확인 
	public int userCheck(String id, String pwd) {
		int result = 1;
		Connection conn = null;
		String sql = "select * from Board where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//비밀번호가 같으면
				if (pwd.equals(rs.getString("pwd"))) {
					result = 2; // 회원으로 로그인 성공
				}else {
					result = 1; // 비밀번호 불일치로 로그인 실패
				}
			}else {
				result = 0; // 아이디 불일치로 로그인 실패
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;		
	}
	
	public BoardVO getMember(String id) {
		BoardVO member=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from Board where id=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new BoardVO(); 
				member.setId(rs.getString("id")); 
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setGender(rs.getString("gender"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
		
	}
	
	public void insertMember(BoardVO member) {
		String sql = "insert into Board values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());
			
			System.out.println(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 회원 수정
		public void updateMember(BoardVO member) {
			String sql = "update Board set email=?,phone=? where id=?";// 비밀번호 이메일 연락처 수정
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPhone());
				pstmt.setString(3, member.getId());
				
				pstmt.executeUpdate();
				
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		// 회원 삭제
		public void deleteMember(String id) {
			String sql = "delete Board where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				
				pstmt.executeUpdate();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//회원보기
		public ArrayList<BoardVO> getMemberList(){
			ArrayList<BoardVO> b= new ArrayList<BoardVO>();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
						
			try {
				String sql = "select * from Board";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO member = new BoardVO();
					member.setId(rs.getString(1));
					member.setPwd(rs.getString(2));
					member.setName(rs.getString(3));
					member.setEmail(rs.getString(4));
					member.setPhone(rs.getString(5));
					member.setGender(rs.getString(6));
					b.add(member);
				}
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return b;
			
		}
		
		//멤버 찾기
		public BoardVO searchMember(String name) {
		      
		      BoardVO member=null;
		      Connection conn=null;
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      
		      String sql="select * from Board where name=?";
		      
		      try {
		         conn=getConnection();
		         pstmt=conn.prepareStatement(sql);
		         pstmt.setString(1,name);
		         
		         rs=pstmt.executeQuery();
		         
		         if(rs.next()) {
		            member=new BoardVO(); 
		            member.setId(rs.getString("id")); 
		            member.setPwd(rs.getString("pwd"));
		            member.setName(rs.getString("name"));
		            member.setEmail(rs.getString("email"));
		            member.setPhone(rs.getString("phone"));
		            member.setGender(rs.getString("gender"));
		         }
		      }catch(Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {
		            rs.close();
		            pstmt.close();
		            conn.close();
		         }catch(SQLException e) {
		            e.printStackTrace();
		         }
		      }
		      return member;
		   }
		
		//한 명 멤버 꺼내오기
		public BoardVO oneselectMember (String id) {
			BoardVO bvo = new BoardVO();
			
			Connection conn=null;
		    PreparedStatement pstmt=null;
		    ResultSet rs=null;
			
			try {
				conn=getConnection();
				String sql = "select * from Board";
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while (rs.next()) {
					bvo.setId(rs.getString(1));
					bvo.setPwd(rs.getString(2));
					bvo.setName(rs.getString(3));
					bvo.setEmail(rs.getString(4));
					bvo.setPhone(rs.getString(5));
					bvo.setGender(rs.getString(6));
				}
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return bvo;
		}
		public String getPwd1(String id) {
			String pass = "";
			
			Connection conn=null;
		    PreparedStatement pstmt=null;
		    ResultSet rs=null;
			try {
				conn=getConnection();
				String sql="select pwd from Board where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					pass=rs.getString(1);
				}
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return pass;
		}
		
		
}
