package com.lpy.test.base.database.doc;
 
import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
 
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
/**
 * @Title: demo
 * @Description:
 * @author: liaryank
 * @Date: 2020/11/11 3:45 下午
 * @Version: 1.0
 */
public class Generation {
 
    public static void main(String[] args) {
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://192.168.1.222:33306/db_tn_sc68030fea4ca5a0dc");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("iScDb!23465");
        //设置可以获取tables remarks信息
        hikariConfig.setSchema("db_tn_sc68030fea4ca5a0dc");//设置想要导出的schema
        hikariConfig.addDataSourceProperty("db_tn_sc68030fea4ca5a0dc", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
 
        EngineConfig engineConfig = EngineConfig.builder()
                //导出文件地址
                .fileOutputDir("C:/Users/Administrator/Desktop")
                //是否打开文件夹
                .openOutputDir(true)
                //文件类型:html、doc、mockdown
                .fileType(EngineFileType.WORD)
                //模板引擎
                .produceType(EngineTemplateType.freemarker).build();
 
//        ProcessConfig processConfig = ProcessConfig.builder()
//                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
//                //根据名称指定表生成
//                .designatedTableName(new ArrayList<>())
//                //根据表前缀生成
//                .designatedTablePrefix(new ArrayList<>())
//                //根据表后缀生成
//                .designatedTableSuffix(new ArrayList<>()).build();
 
        //设置生成pojo相关配置
        Configuration config = Configuration.builder()
                .version("1.0.0")
                .description("数据库设计文档")
                .dataSource(dataSource)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig()).build();
        new DocumentationExecute(config).execute();
    }
 
    /**
     * 配置想要生成的表+ 配置想要忽略的表
     *
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList();
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList();
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList();
        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(Arrays.asList("invest_actv",
                        "invest_actv_consume",
                        "invest_actv_linkman",
                        "invest_actv_openness",
                        "invest_actv_proc_model",
                        "invest_actv_proc_supp",
                        "invest_actv_procurement",
                        "invest_actv_project",
                        "invest_actv_report",
                        "invest_actv_report_url",
                        "invest_actv_schedule",
                        "invest_actv_source",
                        "invest_actv_stage",
                        "invest_actv_supplier",
                        "invest_actv_task",
                        "invest_actv_type",
                        "invest_appraisal_affiliated_resource",
                        "invest_appraisal_dept_status",
                        "invest_appraisal_object",
                        "invest_appraisal_one_level_item",
                        "invest_appraisal_org_status",
                        "invest_appraisal_process",
                        "invest_appraisal_process_org",
                        "invest_appraisal_rule",
                        "invest_appraisal_score",
                        "invest_appraisal_score_detail",
                        "invest_appraisal_score_info",
                        "invest_appraisal_task_info",
                        "invest_appraisal_task_item",
                        "invest_appraisal_task_item_manager",
                        "invest_appraisal_task_role",
                        "invest_appraisal_task_statement",
                        "invest_appraisal_task_statement_resource",
                        "invest_appraisal_two_level_item",
                        "invest_calculator",
                        "invest_calculator_content",
                        "invest_calculator_content_preferential_policy",
                        "invest_carrier",
                        "invest_carrier_area",
                        "invest_carrier_area_history_info",
                        "invest_carrier_company",
                        "invest_carrier_company_history_info",
                        "invest_carrier_dictionary",
                        "invest_carrier_economic",
                        "invest_carrier_history_info",
                        "invest_carrier_manager_relation",
                        "invest_carrier_statistics",
                        "invest_carrier_title",
                        "invest_intention",
                        "invest_invitation_apply",
                        "invest_invitation_apply_field",
                        "invest_invitation_field_value",
                        "invest_invitation_info",
                        "invest_invitation_source",
                        "invest_invitation_system_field",
                        "invest_link",
                        "invest_link_temporary",
                        "invest_link_type",
                        "invest_linkman_memo",
                        "invest_month",
                        "invest_policy",
                        "invest_preferential_policy",
                        "invest_preferential_policy_content",
                        "invest_project",
                        "invest_project_analysis",
                        "invest_project_contacts",
                        "invest_project_daily_count",
                        "invest_project_demand",
                        "invest_project_dic",
                        "invest_project_economic_benefit",
                        "invest_project_evaluation",
                        "invest_project_exchange",
                        "invest_project_included_statistics",
                        "invest_project_income",
                        "invest_project_investigate",
                        "invest_project_negotiate",
                        "invest_project_object",
                        "invest_project_other",
                        "invest_project_progress",
                        "invest_project_registration",
                        "invest_project_report",
                        "invest_project_resource",
                        "invest_project_sign",
                        "invest_project_sign_detail",
                        "invest_project_sign_subject",
                        "invest_project_site",
                        "invest_project_team",
                        "invest_project_unit",
                        "invest_project_user",
                        "invest_street_manager_relation",
                        "invest_suggestion",
                        "baoan_uauth_org",
                        "baoan_uauth_user"))
                //根据表前缀生成("a")
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成("_user")
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }
}