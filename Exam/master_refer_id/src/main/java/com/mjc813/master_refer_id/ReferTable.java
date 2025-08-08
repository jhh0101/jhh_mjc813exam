package com.mjc813.master_refer_id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReferTable {
    private Long id;
    private String name;
    private Long masterTableId;
    private MasterTable master;

    public ReferTable(Long id, String name, Long masterTableId, MasterTable master) {
        this.id = id;
        this.name = name;
        this.masterTableId = masterTableId;
//        this.master = master;
        if(master != null){
            this.master = new MasterTable(master.getId(), master.getName());
        }else{
            this.master = new MasterTable();
        }

    }

    public void setMasterTableId(Long masterTableId) {
        this.masterTableId = masterTableId;
        master.setId(masterTableId);

    }

    public Long getMasterTableId() {
        if(this.master == null){
            this.master = new MasterTable();
        }
        return this.master.getId();
    }
}
