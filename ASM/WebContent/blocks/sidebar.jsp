<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="sidebar-container">
    <div class="sidemenu-container navbar-collapse collapse fixed-menu">
        <div id="remove-scroll">
            <ul class="sidemenu  page-header-fixed" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                <li class="sidebar-toggler-wrapper hide">
                    <div class="sidebar-toggler">
                        <span></span>
                    </div>
                </li>
                <c:set var="u">${USER}</c:set>
                <li class="sidebar-user-panel">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="../images/${USER.hinh}" class="img-circle user-img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>${USER.fullname}</p>
                            <a href="#"><i class="fa fa-circle user-online"></i><span class="txtOnline"> Online</span></a>
                        </div>
                    </div>
                </li>
                <li class="nav-item start active">
                    <a href="./index.htm" class="nav-link nav-toggle">
                        <i class="material-icons">dashboard</i>
                        <span class="title">Trang Chủ</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="material-icons">list</i>
                        <span class="title">Quản Lý Tài Khoản</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="./insert.htm" class="nav-link ">
                                <span class="title">Thêm Tài Khoản</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./user.htm" class="nav-link ">
                                <span class="title">Danh Sách Tài Khoản</span>
                            </a>
                        </li>                                        
                    </ul>
                </li> 
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="material-icons">list</i>
                        <span class="title">Quản Lý Phòng Ban</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="./insert-depart.htm" class="nav-link ">
                                <span class="title">Thêm Phòng Ban</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./depart.htm" class="nav-link ">
                                <span class="title">Danh Sách Phòng Ban</span>
                            </a>
                        </li>                                        
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="material-icons">list</i>
                        <span class="title">Quản Lý Nhân Viên</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="./insert-staff.htm" class="nav-link ">
                                <span class="title">Thêm Nhân Viên</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./staff.htm" class="nav-link ">
                                <span class="title">Danh Sách Nhân Viên</span>
                            </a>
                        </li>                                        
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="material-icons">list</i>
                        <span class="title">Khen Thưởng Kỉ Luật </span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="./insert-record.htm" class="nav-link ">
                                <span class="title">Thêm Khen Thưởng Kỉ Luật</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./record.htm" class="nav-link ">
                                <span class="title">Danh Sách Khen Thưởng Kỉ Luật</span>
                            </a>
                        </li>     
                        <li class="nav-item">
                            <a href="./couttype.htm" class="nav-link ">
                                <span class="title">Thống Kê</span>
                            </a>
                        </li>                                   
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link nav-toggle">
                        <i class="material-icons">list</i>
                        <span class="title">Email</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="./email.htm" class="nav-link ">
                                <span class="title">Email</span>
                            </a>
                        </li>                                      
                    </ul>
                </li>
             
            </ul>
        </div>
    </div>
</div>
