/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.ui.habits.list.controllers;

import android.support.annotation.Nullable;

import org.isoron.uhabits.models.Habit;
import org.isoron.uhabits.ui.habits.list.views.HabitCardView;

public class HabitCardController implements HabitCardView.Controller
{
    @Nullable
    private HabitCardView view;

    @Nullable
    private Listener listener;

    @Override
    public void onInvalidToggle()
    {
        if (listener != null) listener.onInvalidToggle();
    }

    @Override
    public void onToggle(Habit habit, long timestamp)
    {
        if (view != null) view.triggerRipple(0, 0);
        if (listener != null) listener.onToggle(habit, timestamp);
    }

    public void setListener(@Nullable Listener listener)
    {
        this.listener = listener;
    }

    public void setView(@Nullable HabitCardView view)
    {
        this.view = view;
    }

    public interface Listener extends CheckmarkButtonController.Listener
    {
    }
}
