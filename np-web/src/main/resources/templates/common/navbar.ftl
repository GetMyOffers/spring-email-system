<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Nebulas Audit System</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i>Hi, ${loginUser.nickname!"unknown"}</i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <#--<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>-->
                <#--</li>-->
                <#--<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>-->
                <#--</li>-->
                <#--<li class="divider"></li>-->
                <#--<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>-->
                <#--</li>-->
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav in" id="side-menu">

                <li>
                    <a href="/dapp/audit/pending"><i class="fa fa-dashboard fa-fw"></i>待分配的DApp</a>
                </li>
                <li>
                    <a href="/dapp/audit/unreview"><i class="fa fa-dashboard fa-fw"></i>已分配未审核的DApp</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 我的审核<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li>
                            <a href="/dapp/audit/my-pending-review?phase=PRE_AUDIT">待初审</a>
                        </li>
                        <li>
                            <a href="/dapp/audit/my-audited-review?phase=PRE_AUDIT">已初审</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="/dapp/all"><i class="fa fa-dashboard fa-fw"></i>全部Dapp列表</a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
</nav>