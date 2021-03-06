/*
 * Copyright (C) 2015-2020 yunjiweidian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.yunji.titan.agent.state;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.yunji.titan.utils.AgentType;

/**
 * 忙碌状态
 * 
 * @author gaoxianglong
 */
public class BusynessState implements AgentState {
	@Override
	public Stat opretion(ZooKeeper zkClient, String nodePath) throws KeeperException, InterruptedException {
		Stat stat = null;
		if (null == zkClient) {
			return stat;
		}
		stat = zkClient.setData(nodePath, AgentType.BUSYNESS, -1);
		return stat;
	}
}